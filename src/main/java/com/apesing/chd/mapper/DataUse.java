package com.apesing.chd.mapper;

import org.apache.ibatis.annotations.Insert;

public interface DataUse {
    @Insert("use dbLataleAccount select * from TbluAccount")
    void useAccount();

    @Insert("use dbLataleWorld_2 select * from TbluPc")
    void useWord();
}
