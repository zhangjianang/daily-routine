package sqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.util.TablesNamesFinder;
import net.sf.jsqlparser.util.cnfexpression.MultipleExpression;
import net.sf.jsqlparser.util.deparser.ReplaceDeParser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by adimn on 2018/2/28.
 */
public class MySqlParser {

    public static void testExtract() throws JSQLParserException {
        Statement statement = CCJSqlParserUtil.parse("INSERT INTO company_change_info (id,company_id,change_item,content_before,content_after,change_time,createTime) VALUES (1587878307,80669612,'经营范围变更','纺纱(凭国家发改委批准文件经营),(有效期限以许可证为准)。棉花收购、销售(有效期至2016年6月1日)；织布、毛巾、无纺棉加工、销售。(依法须经批准的项目，经相关部门批准后方可开展经营活动)。','纺纱(凭国家发改委批准文件经营),(有效期限以许可证为准)。棉花收购、销售；织布、毛巾、无纺棉加工、销售；服装加工、销售。(依法须经批准的项目，经相关部门批准后方可开展经营活动)。','2017-03-28','2017-04-02'),(1587878307,80669612,'经营范围变更','纺纱(凭国家发改委批准文件经营),(有效期限以许可证为准)。棉花收购、销售(有效期至2016年6月1日)；织布、毛巾、无纺棉加工、销售。(依法须经批准的项目，经相关部门批准后方可开展经营活动)。','纺纱(凭国家发改委批准文件经营),(有效期限以许可证为准)。棉花收购、销售；织布、毛巾、无纺棉加工、销售；服装加工、销售。(依法须经批准的项目，经相关部门批准后方可开展经营活动)。','2017-03-28','2017-04-02');");
        Insert selectStatement = (Insert) statement;
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
        ReplaceDeParser replaceDeParser = new ReplaceDeParser();

        System.out.println(tableList.get(0));
        List<Column> columns = selectStatement.getColumns();
        ItemsList itemsList = selectStatement.getItemsList();
        System.out.println(itemsList);
        List il = (ArrayList)itemsList;
        System.out.println(il.get(0));

    }

    public static void main(String[] args) throws JSQLParserException {
        MySqlParser.testExtract();
    }
}
