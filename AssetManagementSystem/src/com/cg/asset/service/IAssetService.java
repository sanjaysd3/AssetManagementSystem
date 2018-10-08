package com.cg.asset.service;

import java.util.ArrayList;

import com.cg.asset.bean.Asset;
import com.cg.asset.exception.AssetException;

public interface IAssetService {

	int addAsset(Asset asset) throws AssetException;
	
	Asset updateAssetById(int assetId) throws AssetException;

	ArrayList<Asset> retrieveAllAssetinfo() throws AssetException;

	int deleteById(int assetId) throws AssetException;

	ArrayList<Asset> retrieveAllocatedAsset(String statusAllocation)
			throws AssetException;

	/*Asset retrieveByAssetName(String assetName) throws AssetException;*/

}
