package com.kjk.gitflowsample.data

import android.util.Log

/**
 *  실제로 로직을 실행하기 위한 Class.
 *  data 가공을 위한 Class.
 *  비즈니스 로직을 담당하는 부분이다.
 *  비즈니스 로직은 Context에 종속적이지 않아야 한다.
 */
class Model {

    private var itemList: ArrayList<DataEntity> = ArrayList()

    /**
     *  data를 생성하는 method
     */
    fun createTestData() {
        for (i in 0 until 20) {
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
        val origin = getItemContents(position)
        Log.w("1111", "updateContents :: ${origin.toString()}")

        // 이미 변경 키워드가 포함 되어 있으면, [변경]은 붙이지 않는다.
        if (origin!!.contains(MODIFY_TEXT)) {
            return
        }
        itemList[position].contents = MODIFY_TEXT + origin
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

    fun getItemList(): ArrayList<DataEntity> {
        return itemList
    }

    companion object {
        private const val MODIFY_TEXT: String = "[변경]"
    }
}