package cn.wenzhuo4657.dailyWeb.domain.Types;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.repository.ITypesRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentName;
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
    public List<Integer> getContentNameIdById(Integer typeId) {
        Integer loginId = SaTokenUtils.getLoginId();
        List<ContentName> list = typesRepository.getContentNameIdById(loginId, typeId);
        return list.stream()
                .map(ContentName::getId)
                .collect(Collectors.toList());
    }
}
