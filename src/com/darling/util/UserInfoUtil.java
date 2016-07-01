package com.darling.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取用户信息类 用户基本信息；单品信息
 * 
 * @author:MushRoom
 * @date:2016-2-14 上午12:12:44
 */
public class UserInfoUtil {

	private int _userid;
	private String _url = "http://1zou.me/api/listtypenum/";
	private Map<String, Integer> _resultMap;
	private String[] _lstTypes;

	public UserInfoUtil(int userid) {
		this._userid = userid;
	}

	/**
	 * 外部入口 获取指定类型单品的个数
	 * 
	 * @author:MushRoom
	 * @date:2016-2-14 上午12:17:37
	 * @param type
	 *            单品类型 eg. upper
	 * @return
	 */
	public int getCountByType(String type) {
		return countByType(type);
	}

	/**
	 * 外部入口 获取所有单品的数量
	 * @author:MushRoom
	 * @date:2016-2-14 上午12:30:49
	 * @return
	 */
	public Map<String, Integer> getCountAll(){
		return countAll();
	}
	
	/**
	 * 获取指定类型单品数量
	 * @author:MushRoom
	 * @date:2016-2-14 上午12:31:19
	 * @param type
	 * @return
	 */
	private int countByType(String type) {		
		String urlStr = this._url + this._userid + "/" + type;
		String strResult = HttpUtils.doGet(urlStr);
		if (strResult.isEmpty()) {
			return 0;
		} else {
			return Integer.parseInt(strResult);
		}
	}
	
	/**
	 * 获取所有单品的数量
	 * @author:MushRoom
	 * @date:2016-2-14 上午12:31:55
	 * @return
	 */
	private Map<String, Integer> countAll(){
		_lstTypes=new String[]{"hat","scarf","upper","skirt","trouser","bag","shoe","waist"};
		_resultMap = new HashMap<String, Integer>();
		
		String type="";
		int count=0;
		for(int i=0;i<this._lstTypes.length;i++){
			type=this._lstTypes[i];
			count=countByType(type);
			this._resultMap.put(type, count);					
		}
		return _resultMap;
			
			
	}

}
