package com.kjk.gitflowsample.data

/**
 *  필요한 data의 형식만을 정의하는 data Class.
 *  - VO(Value Object) : Read Only
 *  - DTO(Data Transfer Object)
 *  - POJO(Plain Old Java Object) 등으로 불리기도 한다.
 *  여기서는 Entity로 한다.
 */
data class DataEntity(
    var contents: String? = null
)