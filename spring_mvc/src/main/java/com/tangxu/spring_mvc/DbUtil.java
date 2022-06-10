package com.tangxu.spring_mvc;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DbUtil {

    //    public static final String URL = "jdbc:mysql://10.22.12.123:3306/icms?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
    public static final String URL = "jdbc:mysql://10.22.12.123:3306/pl?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "MsapTest";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        //INSERT INTO arb_guar_contract_usage (org_id, guar_contract_use_id, max_contract_no, guar_contract_no, cust_no, guar_amt, trxn_amt, apply_no, ccy_code, guar_contract_type, add_sub_flag, data_create_time, data_update_time, data_create_user, data_update_user, data_version) VALUES('985', '000000000000003503', '000000000000006601', '000000000000006601', 'UR00000000006183', 3400000.00, 400000.00, '20220206000000000030102', '156', '0', 'D', '20220531 18:40:10 942', '20220531 18:40:10 942', '00001', '00001', 1);
//        Map<String, Map<String, String>> tableMap = getProdTableMap();
        Map<String, Map<String, String>> tableMap = getPlTable();

        for (String table : tableMap.keySet()) {
            if (table.length() > 0) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\CaiZhang\\Desktop\\6月份\\" + table + ".sql"));
                getTableInsert(stmt, table, tableMap.get(table), writer);
                writer.close();
            }
        }
    }

    private static Map<String, Map<String, String>> getProdTableMap() {


        HashMap<String, Map<String, String>> tableMap = new HashMap<>();

//        tableMap.put("tsp_service_in", new HashMap<>());
        //可售产相关
//        HashMap<String, String> prodMap = new HashMap<>();
//        prodMap.put("sale_prod_cd","CYPOC2");
//        prodMap.put("org_id","985");
//
//        tableMap.put("pdf_prod", prodMap);
//        tableMap.put("pdf_prod_attr", prodMap);
//        tableMap.put("pdf_admit_ctrl", prodMap);
//        tableMap.put("pdf_rule_info_check", prodMap);
//        tableMap.put("pdf_flow_relat", prodMap);
//        tableMap.put("pdf_protocol_template", prodMap);
//        tableMap.put("pdf_channel", prodMap);
//        tableMap.put("pdf_institut", prodMap);
//        tableMap.put("pdf_message_relation", prodMap);
//        tableMap.put("pdf_extra_params", prodMap);
//        tableMap.put("pdf_car_sell_range_relation", prodMap);
//        tableMap.put("pdf_partner_relation", prodMap);
//        tableMap.put("pdf_prod_duedill_template", prodMap);

        //模板相关
//        HashMap<String, String> templateMap = new HashMap<>();
//        templateMap.put("template_id","TP00003502");
//        templateMap.put("org_id","985");
//
//        HashMap<String, String> templateRalMap = new HashMap<>();
//        templateRalMap.put("template_id","TP00003502");
//        templateRalMap.put("org_id","985");
//
//        tableMap.put("pdp_prod_template", templateMap);
//        tableMap.put("pdf_page_relat", templateRalMap);

        //核算
//          HashMap<String, String> lnMap = new HashMap<>();
//          lnMap.put("prod_code","30001");
//          lnMap.put("lgl_pern_code","985");
//
//          tableMap.put("klnf_cmpt_rgstn", lnMap);
//          tableMap.put("klnf_prod_info", lnMap);
//          tableMap.put("klnf_basic_attr", lnMap);
//          tableMap.put("klnf_lendg_attr", lnMap);
//          tableMap.put("klnf_rpymt_attr", lnMap);
//          tableMap.put("klnf_matu_attr", lnMap);
//          tableMap.put("klnf_int_caln_attr", lnMap);
//          tableMap.put("klnf_prcg_attr", lnMap);
//          tableMap.put("klnf_acctg_class", lnMap);
//          tableMap.put("klnf_acctg_attr", lnMap);
//          tableMap.put("klnf_union_loan_attr", lnMap);
//          tableMap.put("klnf_cust_ntc_attr", lnMap);


        return tableMap;
    }

    public static Map<String, Map<String, String>> getPlTable() throws Exception {
        File file = new File("D:\\WorkProject\\ctxd\\4.1\\pl\\pl-dist\\db\\mysql\\all\\dml\\table_pl_init.sql");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        HashMap<String, String> plMap = new HashMap<>();
//        plMap.put("org_id", "985");
        Map<String, Map<String, String>> map = new TreeMap<>();
        String s = bufferedReader.readLine();
        while (s != null) {
            if (s.contains("INSERT INTO")) {
                String[] s1 = s.split(" ");
                String replace = s1[2].replace("`", "");
                map.put(replace, plMap);
            }
            s = bufferedReader.readLine();
        }
        for (String temp : map.keySet()) {
            System.out.println(temp + " " + temp.length());
        }
        return map;

    }

    private static void getTableInsert(Statement stmt, String tableName, Map<String, String> pMap, BufferedWriter writer) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(tableName);
        if (pMap.size() > 0) {
            sql.append(" WHERE");
            for (String s : pMap.keySet()) {
                sql.append(" ").append(s + "=").append("\'" + pMap.get(s) + "\'").append(" and");
            }

        }
        //        System.out.println("sql: "+sql.toString());
        String str = sql.toString();
        if (str.endsWith("and")) {
            str = str.substring(0, str.length() - 4);
        }
//        System.out.println("after"+str);
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(str);
            System.out.println("执行sql   " + str);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(str);
            System.out.println("table" + tableName);
        }

        ResultSetMetaData metaData = rs.getMetaData();
        StringBuilder head = new StringBuilder("INSERT INTO " + tableName + " (");
        //获取表头
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            String columnName = metaData.getColumnName(i);
            if (i == metaData.getColumnCount()) {
                head.append(columnName);
            } else {
                head.append(columnName + ", ");
            }
        }
//        System.out.println(head.toString());
        head.append(") VALUES(");
        while (rs.next()) {
            StringBuilder pre = new StringBuilder(head.toString());
            for (int j = 1; j <= metaData.getColumnCount(); j++) {
                String className = metaData.getColumnClassName(j);
                if (className.equals(Long.class.getName())) {
                    pre.append(rs.getLong(j));
                }
                if (className.equals(Integer.class.getName())) {
                    pre.append(rs.getInt(j));
                }
                if (className.equals(BigDecimal.class.getName())) {
                    pre.append(rs.getBigDecimal(j));
                }
                if (className.equals(String.class.getName())) {
                    pre.append("\'" + rs.getString(j) + "\'");
                }
                if (j == metaData.getColumnCount()) {
                    pre.append(");");
                } else {
                    pre.append(", ");
                }
            }
            String result = pre.toString().replace("\'null\'", "NULL");
//            System.out.println(result);
            writer.write(result);
            writer.newLine();
        }
    }
}