select * from imgboard;

select * from tmp_imgboard;

select *  from board;

select * from comments;

select * from 
(
    select aa.*,rownum rnum from
    (
        select * from imgboard where board_num=1 and img_states!=1
    ) aa
) where rnum >=1 and rnum <=6;

