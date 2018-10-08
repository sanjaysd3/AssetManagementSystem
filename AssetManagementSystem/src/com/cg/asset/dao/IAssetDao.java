package com.cg.asset.dao;

import java.util.ArrayList;

import com.cg.asset.bean.Asset;
import com.cg.asset.exception.AssetException;

public interface IAssetDao {

	int addAsset(Asset asset) throws AssetException;

	ArrayList<Asset> retrieveAllAssetinfo() throws AssetException;

	int deleteById(int assetId) throws AssetException;

	ArrayList<Asset> retrieveAllocatedAsset(String statusAllocation) throws AssetException;

	Asset updateAssetById(int assetId) throws AssetException;

	/*Asset retrieveByAssetName(String assetName);*/

	
	
}
