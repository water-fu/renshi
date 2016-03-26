package com.group.renshi.cache;

import com.group.renshi.constant.SystemConstantType;
import com.group.webFramework.exception.ApplicationException;

/**
 * 总体说明
 * 	专业职称缓存
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ProfessionalCache.java,v 0.1 2015-6-5 上午9:48:47 Exp $
 */
public class ProfessionalCache extends BaseCache {

	/**
	 * 工作职称
	 */
	public static final String WORK = "work";

	/**
	 * 学术职称
	 */
	public static final String ACADEMIC = "academic";

	/**
	 * 教育职称
	 */
	public static final String EDUCATION = "education";

	/**
	 * 
	 */
	public ProfessionalCache() {
		setCacheBool(true);
		setCacheName("专业职称缓存");
	}

	public static synchronized ProfessionalCache getInstance() {
		ProfessionalCache professionalCache = (ProfessionalCache) BaseCache
				.getCachedInstance(ProfessionalCache.class.getName());
		if (professionalCache == null) {
			professionalCache = new ProfessionalCache();
			professionalCache.doSmartLoad();
			BaseCache.setCachedInstance(ProfessionalCache.class.getName(), professionalCache);
		}
		return professionalCache;
	}

	/** 
	 * @see com.group.renshi.cache.BaseCache#reloadAllData()
	 */
	@Override
	protected void reloadAllData() throws ApplicationException {
		put("住院医师", WORK);
		put("主治医师", WORK);
		put("副主任医师", WORK);
		put("主任医师", WORK);

		put("level_住院医师", SystemConstantType.PROFESS_LEVEL_WORK_ONE);
		put("level_主治医师", SystemConstantType.PROFESS_LEVEL_WORK_TWO);
		put("level_副主任医师", SystemConstantType.PROFESS_LEVEL_WORK_THREE);
		put("level_主任医师", SystemConstantType.PROFESS_LEVEL_WORK_FOURTH);

		put("讲师", ACADEMIC);
		put("副教授", ACADEMIC);
		put("教授", ACADEMIC);

		put("硕士生导师", EDUCATION);
		put("博士生导师", EDUCATION);
	}
}
