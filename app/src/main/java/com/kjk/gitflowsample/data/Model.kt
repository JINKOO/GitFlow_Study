package com.kjk.gitflowsample.data

/**
 *  실제로 로직을 실행하기 위한 Class.
 *  data 가공을 위한 Class.
 */
class Model {

    private var itemList: ArrayList<DataEntity> = ArrayList()

    /**
     *  data를 생성하는 method
     */
    fun createTestData() {
        for (i in 0 until 100) {
            var dataEntity = DataEntity()
            dataEntity.contents = "${i}번째 아이템"
            itemList.add(dataEntity)
        }
    }

    /**
     * 선택한 아이템의 contents를 변경하는 함수
     */
    //TODO 파라미터 추가.
    fun updateContents(position: Int) {
        itemList[position].contents = "변경할 data"
    }

    /**
     *  data를 모두 지우는 method
     */
    fun deleteAllData() {
        itemList.clear()
    }

    /**
     *  특정 item의 contents를 가져오는 함수
     */
    fun getItemContents(position: Int): String? {
        return itemList[position].contents
    }
}