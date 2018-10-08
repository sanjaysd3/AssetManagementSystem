package com.cg.asset.dbutil;

public interface IQueryMapper {

public static final	String INSERT_ASSET_INFO="INSERT INTO ASSET values(asset_seq.NEXTVAL,?,?,?,?)";
//public static final	String RETRIEVE_ASSET_BY_ID="SELECT * FROM ASSET where asset_id=?";
public static final	String ASSET_SEQ_CURR_ID="SELECT asset_seq.currval FROM dual";
public static final	String RETRIEVE_ALL_ASSET="SELECT * FROM ASSET";
public static final String DELETE ="DELETE FROM ASSET where asset_id=?";

}
