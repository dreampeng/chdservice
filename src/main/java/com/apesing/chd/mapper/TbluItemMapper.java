package com.apesing.chd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TbluItemMapper {
    @Insert("use dbLataleWorld_2 INSERT INTO TbluItem2 \n" +
            "\t( UID, CharID, ContainerType, ContainerSlot,TypeID,  Cnt,Rare,\n" +
            "\t OptType1, OptVal1, OptType2, OptVal2,OptType3, OptVal3,OptType4, OptVal4,OptType5, OptVal5,\n" +
            "\t BackPrice,IsCash) VALUES \n" +
            "\t( #{item.uid}, #{item.charid}, #{item.containertype}, #{item.containerslot},#{item.typeid},  #{item.cnt}, #{item.rare}, \n" +
            "\t  0,0,0,0,0,0,0,0,0,0, \n" +
            "\t  0,0);")
    void insert(@Param("item") Map<String, Object> item);

    @Select("use dbLataleWorld_2 select  UID, CharID, ContainerType, ContainerSlot,TypeID,  Cnt,Rare," +
            "OptType1, OptVal1, OptType2, OptVal2,OptType3, OptVal3,OptType4, OptVal4,OptType5, OptVal5," +
            "BackPrice,IsCash from TbluItem2 where UID = #{uid} and ContainerType = #{type}" +
            " order by ContainerSlot")
    List<Map<String, Object>> getListByUidAndType(@Param("uid") int uid, @Param("type") int type);

}
