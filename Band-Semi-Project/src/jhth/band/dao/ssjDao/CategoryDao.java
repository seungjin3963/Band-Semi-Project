package jhth.band.dao.ssjDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhth.band.vo.ssjVo.BcategoryVo;
import jhth.band.vo.ssjVo.ScategoryVo;

public class CategoryDao {
	public ArrayList<BcategoryVo> bcategory(int category){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BcategoryVo> list=new ArrayList<BcategoryVo>();
		
		
		int startnum=category;
		int endnum=startnum+9;
		
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("SELECT * FROM BCATEGORY WHERE BCATEGORYNUM>=? AND BCATEGORYNUM<=? ORDER BY BCATEGORYNUM ASC");
			pstmt.setInt(1, startnum);
			pstmt.setInt(2, endnum);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int bcategoryNum=rs.getInt("bcategorynum");
				String category_btitle = rs.getString("category_btitle");
				String categoryimg = rs.getNString("categoryimg");
				
				BcategoryVo vo=new BcategoryVo(bcategoryNum, category_btitle, categoryimg);
				
				list.add(vo);
			}
			
			return list;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	
	public ArrayList<ScategoryVo> scategory(int bcategorynum){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ScategoryVo> list=new ArrayList<ScategoryVo>();
		
		
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("SELECT * FROM SCATEGORY WHERE BCATEGORYNUM=?");
			pstmt.setInt(1, bcategorynum);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				long scategoryNum=rs.getLong("scategorynum");
				String category_stitle=rs.getString("category_stitle");
				
				ScategoryVo vo=new ScategoryVo(scategoryNum, bcategorynum, category_stitle);
				list.add(vo);
			}
			
			return list;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
