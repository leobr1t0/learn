package tests.tests.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tests.tests.model.Student;
import tests.tests.model.Tagger;

import java.util.Optional;

@Configuration
public class MetricsConfig {

    public static Tagger map(Student student) {
        if (student == null) {
            return null;
        }
        return new Tagger(student.getGender(), student.getCourse());
    }

    public void addCommonTags(MeterRegistry registry, Tagger tagger) {
        registry.config().commonTags(
                "gender", Optional.ofNullable(tagger.getGender()).orElse("N/A"),
                "course", Optional.ofNullable(tagger.getCourse()).orElse("N/A")
        );
    }
}