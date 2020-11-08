package app.page;

import freemarker.cache.TemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Построитель страниц из шаблонов ftl
 *
 * @author vasil
 */
@Slf4j
public class PageBuilder {

    private Map<String, Object> param;
    private final String templateName;

    public PageBuilder(String templateName) {
        this.templateName = templateName;
    }

    public PageBuilder setAttribute(Map<String, Object> param) {
        if (param != null) {
            this.param = param;
        } else {
            this.param = new HashMap<>();
        }
        return this;
    }

    // Генерирует текст страницы из шаблона
    public String generate() {
        String result = null;
        try {
            Template template = getTemplateFromClass(templateName);
            try (Writer out = new StringWriter()) {
                template.process(this.param, out);
                result = out.toString();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            log.info("result = {}", result);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    private Template getTemplateFromFile(String path, String templateName) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        cfg.setDefaultEncoding("UTF-8");
        return null;
    }

    private Template getTemplateFromResources(String templateName) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        cfg.setDefaultEncoding("UTF-8");
        return null;
    }

    private Template getTemplateFromClass(String templateName) throws MalformedTemplateNameException, ParseException, IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(TemplateLoader.class, "/templates");
        Template template = cfg.getTemplate(templateName);
        return template;
    }

}
