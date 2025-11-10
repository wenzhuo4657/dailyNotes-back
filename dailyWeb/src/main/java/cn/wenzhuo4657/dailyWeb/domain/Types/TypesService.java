package cn.wenzhuo4657.dailyWeb.domain.Types;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.ContentNameDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.DocsDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.repository.ITypesRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Docs;
import cn.wenzhuo4657.dailyWeb.utils.SaTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypesService  implements   ITypesService{

    @Autowired
    private ITypesRepository typesRepository;

    @Override
    public List<TypeDto> getAllTypes() {

        Integer loginId = SaTokenUtils.getLoginId();
        return typesRepository.getAllByUserId(loginId);
    }

    @Override
    public List<DocsDto> getContentNameIdById(Integer typeId) {
        Integer loginId = SaTokenUtils.getLoginId();
        List<Docs> list = typesRepository.getDocsIdByTypeId(loginId, typeId);
        return list.stream()
                .map(

                                contentName -> {
                                    DocsDto dto=new DocsDto();
                                    dto.setId(contentName.getDocsId());
                                    dto.setName(contentName.getName());
                                    return dto;
                                }

                )
                .collect(Collectors.toList());
    }
}
