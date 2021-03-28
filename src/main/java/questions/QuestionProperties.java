package questions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QuestionProperties {
        @Value("${question.template}")
        public String template;
}
