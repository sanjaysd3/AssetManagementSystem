package com.cg.asset.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.asset.bean.Asset;
import com.cg.asset.dbutil.DbConnectivity;
import com.cg.asset.dbutil.IQueryMapper;
import com.cg.asset.exception.AssetException;




public class AssetDaoImpl implements IAssetDao {
	
	Logger log = null;

	public AssetDaoImpl(){
		PropertyConfigurator.configure("src/resources/log4j.properties");
		log = Logger.getRootLogger();
		log.setLevel(Level.ALL);
		
	}

	Connection conn = null;

	@Override
	public int addAsset(Asset asset) throws AssetException {
		int assetId = 0;
		try {
			log.info("program for insertion started");
			conn = DbConnectivity.getConnected();
			PreparedStatement pst = conn.prepareStatement(IQueryMapper.INSERT_ASSET_INFO);
			pst.setString(1, asset.getAssetName());
			log.info("name is set :: " + asset.getAssetName());
			pst.setString(2, asset.getAssetDesc());
			pst.setInt(3, asset.getAssetQuantity());
			pst.setString(4, asset.getAssetStatus());
			log.warn("data may not be stored due to DB issue");
			int status = pst.executeUpdate();
			log.info("data is getting stored");
			if (status >= 1) {
				
				pst = conn.prepareStatement(IQueryMapper.ASSET_SEQ_CURR_ID);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					assetId = rs.getInt(1);
					log.info("data is stored with asset id :: "+assetId);
					
				}
			}

		} catch (SQLException e) {
			log.error("error : "+e.getMessage());
			// throws user defined exception
			throw new AssetException("DB problem : " + e.getMessage());

		}
		return assetId;
	}

	@Override
	public ArrayList<Asset> retrieveAllAssetinfo() throws AssetException {
		ArrayList<Asset> assetList = new ArrayList<Asset>();
		try {
			conn = DbConnectivity.getConnected();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(IQueryMapper.RETRIEVE_ALL_ASSET);
			Asset asset = null;

			while (rs.next()) {
				asset = new Asset();
				asset.setAssetId(rs.getInt(1));
				asset.setAssetName(rs.getString(2));
				asset.setAssetDesc(rs.getString(3));
				asset.setAssetQuantity(rs.getInt(4));
				asset.setAssetStatus(rs.getString(5));
				assetList.add(asset);
			}

		} catch (SQLException e) {
			throw new AssetException("exception occured :: " +e.getMessage());
		}

		return assetList;
	}

	@Override
	public int deleteById(int assetId) throws AssetException {
		int status=0;
		try {
		conn=DbConnectivity.getConnected();
		PreparedStatement st=conn.prepareStatement(IQueryMapper.DELETE);
		st.setInt(1, assetId);
		status=st.executeUpdate();
		return status;
	}
		catch (SQLException e) {
			throw new AssetException("exception occured :: " +e.getMessage());
		}
	}

	@Override
	public ArrayList<Asset> retrieveAllocatedAsset(String statusAllocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset updateAssetById(int assetId) {
		// TODO Auto-generated method stub
		return null;
	}

}
