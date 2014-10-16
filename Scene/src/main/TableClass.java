package main;


import interfaces.Tableterface;

import java.util.*;

import util.annotations.Tags;
@Tags({"generic"})
public class TableClass<KeyType,ValueType> implements Tableterface<KeyType,ValueType> {
	
	
	List <KeyType>   keys = new ArrayList<KeyType>();
	List<ValueType>  val=new ArrayList<ValueType>();
	
	public void put (KeyType key, ValueType value)
	{   
		if(key==null||value==null)
		{
			return;
			
		}
		else
		if(!key.equals(null)&&!value.equals(null))
		{
			if(keys.contains(key))
			{
				
			val.set(keys.indexOf(key),value);	
				
			}
			else
			{
				
				keys.add(key);
				val.add(value);
			
			}
			
			
		}
	}
	public List<KeyType> getKeys ()
	{
		return keys;
	}
	public List<ValueType> getVal()
	{
		
		return val;
	}
	public ValueType get (KeyType key)
	{
		ValueType valuez;
if(!keys.contains(key))	
{
	valuez=null;
	
}
else
	
	{
		
	
	valuez=val.get(keys.indexOf(key));
	}
	
return valuez;
	
	}
}
