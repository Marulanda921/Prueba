package com.Riwi.Prueba.Infraestructure;

import org.springframework.data.domain.Page;

public interface CrudService<RQ,RS,ID>{
    public RS create(RQ request);
    public Page<RS> getAll(int page, int size);
    public RS get(ID id);
    public void delete(ID id);
    public RS update(RQ request, ID id);





}
