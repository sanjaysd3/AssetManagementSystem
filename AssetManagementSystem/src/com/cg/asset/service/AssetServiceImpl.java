package com.cg.asset.service;

import java.util.ArrayList;

import com.cg.asset.bean.Asset;
import com.cg.asset.dao.AssetDaoImpl;
import com.cg.asset.dao.IAssetDao;
import com.cg.asset.exception.AssetException;


public class AssetServiceImpl implements IAssetService{
	
	
	IAssetDao assetdao=null;
	
	@Override
	public int addAsset(Asset asset) throws AssetException {
		
		assetdao=new AssetDaoImpl();
		return assetdao.addAsset(asset);
	}
	
	public Asset updateAssetById(int assetId) throws AssetException {
		assetdao=new AssetDaoImpl();
		return assetdao.updateAssetById(assetId);
	}

	/*@Override
	public Asset retrieveByAssetName(String assetName) throws AssetException {
		assetdao=new AssetDaoImpl();
		return assetdao.retrieveByAssetName(assetName);
	}*/

	@Override
	public ArrayList<Asset> retrieveAllAssetinfo() throws AssetException {
		assetdao=new AssetDaoImpl();
		return assetdao.retrieveAllAssetinfo();
	}

	@Override
	public int deleteById(int assetId) throws AssetException {
		assetdao=new AssetDaoImpl();
		return assetdao.deleteById(assetId);
	}
	
	@Override
	public ArrayList<Asset> retrieveAllocatedAsset(String statusAllocation) throws AssetException {
		assetdao=new AssetDaoImpl();
		return assetdao.retrieveAllocatedAsset(statusAllocation);
	}

}
