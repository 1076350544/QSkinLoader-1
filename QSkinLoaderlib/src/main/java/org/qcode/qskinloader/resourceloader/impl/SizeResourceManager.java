package org.qcode.qskinloader.resourceloader.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import org.qcode.qskinloader.IResourceManager;
import org.qcode.qskinloader.base.utils.ResourceUtils;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/5/17
 *     desc   : 字体大小管理器
 * </pre>
 */

public class SizeResourceManager implements IResourceManager
{

	private Context mContext;
	private Resources mDefaultResources;
	private String mPackageName;
	private Resources mResources;
	private String mSuffix = null;

	public SizeResourceManager(Context context, String pkgName, Resources resources)
	{
		mContext = context;
		mPackageName = pkgName;
		mResources = resources;
		mDefaultResources = mContext.getResources();
	}

	public SizeResourceManager(Context context, String suffix, String pkgName, Resources resources)
	{
		this(context, pkgName, resources);
		mSuffix = suffix;
	}

	@Override
	public void setBaseResource(String skinIdentifier, IResourceManager baseResource)
	{

	}

	@Override
	public String getSkinIdentifier()
	{
		return null;
	}

	@Override
	public boolean isDefault()
	{
		return false;
	}

	@Override
	public int getColor(int resId)
	{
		return -1;
	}

	@Override
	public int getColor(int resId, String resName)
	{
		return -1;
	}

	public Drawable getDrawable(int resId)
	{
		return null;
	}

	@SuppressLint("NewApi")
	public Drawable getDrawable(int resId, String resName)
	{
		return null;
	}

	@Override
	public ColorStateList getColorStateList(int resId)
	{
		return null;
	}

	/**
	 * 读取ColorStateList
	 * @param resId
	 * @return
	 */
	@Override
	public ColorStateList getColorStateList(int resId, String resName)
	{
		return null;
	}

	@Override
	public ColorStateList getColorStateList(int resId, String typeName, String resName)
	{
		return null;
	}

	/** VeiZhang Text **/
	@Override
	public String getString(int resId, String typeName, String resName)
	{
		return null;
	}

	/** VeiZhang TextSize **/
	@Override
	public int getDimen(int resId, String typeName, String resName) throws Resources.NotFoundException
	{
		String trueResName = appendSuffix(resName);
		int trueResId = ResourceUtils.getIdentifier(mResources, trueResName, typeName, mPackageName, resName);
		return mResources.getDimensionPixelOffset(trueResId);
	}

	private String appendSuffix(String resName)
	{
		return resName + mSuffix;
	}
}
