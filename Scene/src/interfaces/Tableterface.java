package interfaces;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.LIST_PATTERN) 

public interface Tableterface<KeyType,ValueType> {
	public void put (KeyType key, ValueType value);
	public List<ValueType> getVal();
	public List<KeyType> getKeys ();

	public ValueType get (KeyType key);
}
