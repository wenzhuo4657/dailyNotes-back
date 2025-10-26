package cn.wenzhuo4657.dailyWeb.domain.Types;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.repository.ITypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesService  implements   ITypesService{

    @Autowired
    private ITypesRepository typesRepository;

    @Override
    public List<TypeDto> getAllTypes(Integer userId) {

        return typesRepository.getAllByUserId(userId);

    }
}
