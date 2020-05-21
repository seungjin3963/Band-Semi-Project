package jhta.band.bandSerch.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import jhta.band.bandSerch.Vo.bandVo;
import jhta.band.db.JDBCUtil;
import jhth.band.vo.MakeBandVo.MakebandVo;

public class bandSerchDao {
	
public ArrayList<bandVo> random(){
		
		String sql="";
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		int a[] = new int[10]; 
        Random r = new Random(); 
        for(int i=0;i<=9;i++){
            a[i] = r.nextInt(10)+1; 
            for(int j=0;j<i;j++){//?—¬ê¸°ì—?„œ ë°´ë“œê³µê°œ?—¬ë¶??„ ?Œ?‹¨?•´?„œ iê°ì‚°?•˜ê¸?
                if(a[i]==a[j]){
                	//a[i]ë¡? rs?žˆ?Š”ì§? ?Œë³„í•˜ê¸?
                    i--;//?®?–´?“°ê¸?..?
                }
            }
        }
		ArrayList<bandVo> list=new ArrayList<bandVo>();
		/*sql="select s.* from" + 
				"(" + 
				"select * from band1 order by dbms_random.value" + 
				")s" + 
				"where rownum <=10";*/
		 //sql="select * from band1 where band_num>0 and band_num<11";
		 //sql="select * from band1 where band_num in(?,?,?,?,?,?,?,?,?,?) and band_publicwhe!=3";
		 sql="select * from band1 where band_num in(?,?,?,?,?,?,?,?,?,?)";
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,a[0]);
			pstmt.setInt(2,a[1]);
			pstmt.setInt(3,a[2]);
			pstmt.setInt(4,a[3]);
			pstmt.setInt(5,a[4]);
			pstmt.setInt(6,a[5]);
			pstmt.setInt(7,a[6]);
			pstmt.setInt(8,a[7]);
			pstmt.setInt(9,a[8]);
			pstmt.setInt(10,a[9]);
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
			String sql="select NVL(count(*),0) cnt from band where band_name like '%"+keyword+"%' or band_introductio like '%"+keyword+"%'";
			
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
	public ArrayList<MakebandVo> serch1(int startRow,int endRow,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql=null;
			
				sql="select * from" + 		
						"    (" + 
						"        select aa.*,rownum rnum from" + 
						"        (" + 
						"            select * from band where band_name like '%"+keyword+"%' or band_intoroductio like '%"+keyword+"%' order by band_num desc" + 
						"        )aa" + 
						")where rnum>=? and  rnum<=?";
			
		    pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<MakebandVo> list=new ArrayList<MakebandVo>();
			while(rs.next()) {
				int band_num=rs.getInt("band_num");
				String band_name=rs.getString("band_name");
				String band_introductio=rs.getString("band_introductio");
				list.add(new MakebandVo(band_num, 0, band_name, 0, band_introductio, 0, null, 0));
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}	
	}
}
