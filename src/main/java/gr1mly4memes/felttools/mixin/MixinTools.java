package gr1mly4memes.felttools.mixin;

import gr1mly4memes.felttools.mixin.annotation.CreateConstructorProcessor;
import gr1mly4memes.felttools.mixin.annotation.MixinProcessor;
import gr1mly4memes.felttools.mixin.annotation.RenameIntoProcessor;
import gr1mly4memes.felttools.mixin.annotation.TransformAccessProcessor;
import gr1mly4memes.felttools.mixin.injector.Decorator;
import gr1mly4memes.felttools.mixin.injector.DecoratorInfo;
import gr1mly4memes.felttools.mixin.injector.EjectorInfo;
import java.util.List;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;

public class MixinTools {

    private final static List<MixinProcessor> postProcessors = List.of(
            new RenameIntoProcessor(),
            new TransformAccessProcessor(),
            new CreateConstructorProcessor()
    );

    public static void setup() {
        InjectionInfo.register(EjectorInfo.class);
        InjectionInfo.register(DecoratorInfo.class);
    }

    public static void onPostMixin(String targetClassName, ClassNode targetClass, IMixinInfo mixinInfo) {
        for (var processor : postProcessors) {
            processor.accept(targetClassName, targetClass, mixinInfo);
        }
        Decorator.postMixin(targetClass);
    }
}
