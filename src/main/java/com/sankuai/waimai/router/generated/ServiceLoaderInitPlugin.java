package com.sankuai.waimai.router.generated;

import com.sankuai.waimai.router.core.Debugger;
import com.sankuai.waimai.router.interfaces.Const;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by BSONG on 2019/9/1.
 */
public class ServiceLoaderInitPlugin implements Plugin {

    private Set<String> serviceInitClss = new HashSet<>();

    @Override
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        if (matches(typeDescription)) {
            serviceInitClss.add(typeDescription.getName());
        }

        return builder.name("empty");
    }

    @Override
    public void close() throws IOException {
        //生成ServiceLoaderInit
        generate(serviceInitClss);
    }

    @Override
    public boolean matches(TypeDescription typeDefinitions) {
        if (typeDefinitions.isPackageType()) {
            return false;
        }

        if (typeDefinitions.getSimpleName().startsWith("ServiceInit_") && typeDefinitions.getPackage().getName().equalsIgnoreCase(Const.GEN_PKG_SERVICE)) {
            return true;
        }

        return false;
    }

    void generate(Set<String> classes) {
        if (classes.isEmpty()) {
            Debugger.i("GenerateInit: skipped, no service found");
            return;
        }

        try {
            Debugger.i("GenerateInit: start...");
            long ms = System.currentTimeMillis();

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            ClassVisitor cv = new ClassVisitor(Opcodes.ASM5, writer) {
            };
            String className = Const.SERVICE_LOADER_INIT.replace('.', '/');
            cv.visit(50, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);

            MethodVisitor mv = cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                    Const.INIT_METHOD, "()V", null, null);

            mv.visitCode();

            for (String clazz : classes) {
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, clazz.replace('.', '/'),
                        "init",
                        "()V",
                        false);
            }
            mv.visitMaxs(0, 0);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitEnd();
            cv.visitEnd();

            File dest = new File(ServiceLoaderInitPlugin.class.getClassLoader().getResource("").getPath(), className + ".class");
            dest.getParentFile().mkdirs();
            new FileOutputStream(dest).write(writer.toByteArray());

            Debugger.i("GenerateInit: cost %s ms", System.currentTimeMillis() - ms);

        } catch (IOException e) {
            Debugger.fatal(e);
        }
    }
}
