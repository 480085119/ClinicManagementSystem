package cn.project.mapper.templateMapper;

import cn.project.entity.Template;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TemplateMapper {
    List<Template> getAllTemplate(Map<String,Object> map);
}
