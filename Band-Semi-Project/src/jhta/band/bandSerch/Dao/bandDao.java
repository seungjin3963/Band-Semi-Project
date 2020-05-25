package jhta.band.bandSerch.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import jhta.band.bandSerch.Vo.bandSerchVo;
import jhta.band.bandSerch.Vo.bandVo;
import jhta.band.db.JDBCUtil;

public class bandDao {
	public ArrayList<bandVo> bigCategoryView(String category_btitle){
		String sql="select ss.categoty_stitle" + 
				"from scategory.ss1,bcategory.bb" + 
				"where bb.bcategoryNum=aa.bcategoryNum and bb.category_btitle=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<bandVo> list=new ArrayList<bandVo>();
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,category_btitle);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String categoty_stitle=rs.getString("categoty_stitle");
			//	list.add(new bandVo(band_num, band_name, band_intoroductio));
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	public ArrayList<bandVo> categoryContents(int scategoryNum){
		String sql="select aa.band_name,aa.band_intoroductio,aa.band_img" + 
				"    from scategory.ss2,band.aa,bandimg.bi" + 
				"    where ss.scategoryNum=aa.scategoryNum and bb.band_publicwhe!=3 and ss.category_stitle=?" + 
			/*	"    =(" + 
				"        select ss.categoty_stitle" + 
				"        from scategory.ss1,bcategory.bb" + 
				"        where bb.bcategoryNum=aa.bcategoryNum and bb.category_btitle=?" + 
				"    ) "*/
				"and bi.bandimgNum=aa.bandimgNum" + 
				"    order by ss.scategoryNum desc";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<bandVo> list=new ArrayList<bandVo>();
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,scategoryNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int band_num=rs.getInt("band_num");
				String band_name=rs.getString("band_name");
				String band_intoroductio=rs.getString("band_intoroductio");
				list.add(new bandVo(band_num, band_name, band_intoroductio));
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	public int getCount(String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(count(*),0) cnt from band where (band_name like '%"+keyword+"%' or band_intoroductio like '%"+keyword+"%') and band_publicwhe!=3";
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int cnt=rs.getInt("cnt");
				return cnt;
			}
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}	
	}
	public ArrayList<bandSerchVo> serch1(int startRow,int endRow,String keyword){
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql1="select a1,a2,a3,b1 from" + 
					"(" + 
					"    select aa.band_num a1 , aa.band_name a2, aa.band_intoroductio a3, bb.login_num b1 rownum rnum from" + 
					"    (" + 
					"        select * from" + 
					"        band where band_name  like '%"+keyword+"%' or band_intoroductio like '%"+keyword+"%' " + 
					"        order by band_num desc" + 
					"    ) aa,band_userinfo bb,login cc" + 
					"    where aa.band_num=bb.band_num and cc.login_num=bb.login_num" + 
					") " + 
					"where rnum>=? and  rnum<=?";
			String sql2="select a1,a2,a3,d1 from( select aa.band_num a1 , aa.band_name a2, aa.band_intoroductio a3, dd.bandimg d1, rownum rnum from  ( select * from  band where (band_name  like '%"+keyword+"%' or band_intoroductio like '%"+keyword+"%') and band_publicwhe!=3  order by band_num desc  ) aa,bandimg dd  where  dd.bandimgNum=aa.bandimgNum) where rnum>=? and  rnum<=?";
			con=JDBCUtil.getConn();
			String sql=null;
			
				sql="select * from" + 		
						"    (" + 
						"        select aa.*,rownum rnum from" + 
						"        (" + 
						"            select * from band where band_name like '%"+keyword+"%' or band_intoroductio like '%"+keyword+"%' order by band_num desc" + 
						"        )aa" + 
						")where rnum>=? and  rnum<=?";
			
		    pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<bandSerchVo> list=new ArrayList<bandSerchVo>();
			while(rs.next()) {
				int band_num=rs.getInt("a1");
				String bandLeader=getBandLeader(band_num);
				String band_name=rs.getString("a2");
				String band_intoroductio=rs.getString("a3");
				String bandimg=rs.getString("d1");
				
				list.add(new bandSerchVo(band_num, band_name, band_intoroductio, bandimg, bandLeader));
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}	
	}
	public ArrayList<Integer> getBandNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Integer> list=new ArrayList<Integer>();
		try {
			con=JDBCUtil.getConn();
			String sql="select band_num "
					+ "from band where band_publicwhe!=3 rownum<10 and rownum>=0"
					+ "order by dbms_random.value ";
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int band_num=rs.getInt("band_num");
				list.add(band_num);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	public ArrayList<bandSerchVo> random(){
		
		String sql="";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int a[] = new int[10]; 
        Random r = new Random();
       // ArrayList<Integer> list1=getBandNum();
        
        for(int i=0;i<=9;i++){
            a[i] = r.nextInt(10)+1; 
            for(int j=0;j<i;j++){//?—¬ê¸°ì—?„œ ë°´ë“œê³µê°œ?—¬ë¶??„ ?Œ?‹¨?•´?„œ iê°ì‚°?•˜ê¸?
                if(a[i]==a[j]){
                	//a[i]ë¡? rs?žˆ?Š”ì§? ?Œë³„í•˜ê¸?
                    i--;//?®?–´?“°ê¸?..?
                }
            }
        }
        
		ArrayList<bandSerchVo> list=new ArrayList<bandSerchVo>();
		 //sql="select * from band1 where band_num>0 and band_num<11";
		 //sql="select * from band1 where band_num in(?,?,?,?,?,?,?,?,?,?) and band_publicwhe!=3";
		 //sql="select * from band where band_num in(?,?,?,?,?,?,?,?,?,?) order by dbms_random.value";
		 String sql2="select aa.* from(select * from band where band_publicwhe!=3  order by dbms_random.value )aa where rownum<=10 and rownum>=1";
		 try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql2);
	/*		pstmt.setInt(1,a[0]);
			pstmt.setInt(2,a[1]);
			pstmt.setInt(3,a[2]);
			pstmt.setInt(4,a[3]);
			pstmt.setInt(5,a[4]);
			pstmt.setInt(6,a[5]);
			pstmt.setInt(7,a[6]);
			pstmt.setInt(8,a[7]);
			pstmt.setInt(9,a[8]);
			pstmt.setInt(10,a[9]);*/
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int band_num=rs.getInt("band_num");
				int bandimgnum=rs.getInt("bandimgnum");
				
				String bandimg=getBandImg(bandimgnum);
				String bandLeader=getBandLeader(band_num);
				
				String band_name=rs.getString("band_name");
				String band_intoroductio=rs.getString("band_intoroductio");
				list.add(new bandSerchVo(band_num, band_name, band_intoroductio, bandimg, bandLeader));
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	public String getBandLeader(int band_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String bandleader=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select cc.login_id bandLeader from band aa,band_userinfo bb,login cc where bb.login_num=cc.login_num and aa.band_num=? and bb.band_approved=1";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,band_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bandleader=rs.getString("bandLeader");
			}
			return bandleader;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	public String getBandImg(int bandimgnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String bandimg=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from bandimg where bandimgnum=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bandimgnum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bandimg=rs.getString("bandimg");
			}
			return bandimg;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
    }
	public ArrayList<bandVo> serch(String keyword){
		String sql="";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<bandVo> list=new ArrayList<bandVo>();
		 //sql="select * from band1 where (band_name like '%"+keyword+"%' or band_intoroductio like '%"+keyword+"%') and band_publicwhe!=3";
			sql="select * from band1 where band_name like '%"+keyword+"%' or band_intoroductio like '%"+keyword+"%'";
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1,startRow);
//			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int band_num=rs.getInt("band_num");
				String bandimg=getBandImg(band_num);
				String band_name=rs.getString("band_name");
				String band_intoroductio=rs.getString("band_intoroductio");
				list.add(new bandVo(band_num, band_name, band_intoroductio));
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
}
