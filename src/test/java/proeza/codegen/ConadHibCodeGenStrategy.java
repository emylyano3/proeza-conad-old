package proeza.codegen;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;

public class ConadHibCodeGenStrategy extends DelegatingReverseEngineeringStrategy {

	public ConadHibCodeGenStrategy (ReverseEngineeringStrategy delegate) {
		super(delegate);
	}
	//
	//	@Override
	//	public String columnToPropertyName (TableIdentifier table, String column) {
	//		if (column.endsWith("_id")) {
	//			return "id";
	//		} else {
	//			return super.columnToPropertyName(table, column);
	//		}
	//	}
	//
	//	@Override
	//	public boolean excludeColumn (TableIdentifier table, String columnName) {
	//		if (columnName.endsWith("_on")) {
	//			return true;
	//		} else {
	//			return super.excludeColumn(table, columnName);
	//		}
	//	}
	//
	//	@Override
	//	public boolean excludeTable (TableIdentifier table) {
	//		if (table.getName().startsWith("stat")) {
	//			return true;
	//		} else {
	//			return super.excludeTable(table);
	//		}
	//	}
}