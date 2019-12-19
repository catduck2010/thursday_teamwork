package com.thursday.util.db;

import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * 对访问数据库统一管理
 *
 * @author yhy
 *
 */
public abstract class AbstractDao {

    private Connection conn;
    private final String db;

    public AbstractDao(String db) {
        this.db = db;
    }

    /**
     * 获得连接
     *
     * @return
     */
    public Connection getConnection() throws SQLException{
        conn = connect(db);
        return conn;
    }

    private Connection connect() throws SQLException{
        Connection conn = null;
        String jdbcURL = "jdbc:mysql://" + DBInfo.IP + ":" + DBInfo.PORT + "/"
                + DBInfo.DBNAME + "?useUnicode=true&characterEncoding=UTF8";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        try {
            //DbUtils中加载驱动的方法
            DbUtils.loadDriver(jdbcDriver);
            conn = DriverManager.getConnection(jdbcURL,
                    DBInfo.USER, DBInfo.PASSWD);
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

    private Connection connect(String db) throws SQLException{
        Connection conn = null;
        String jdbcURL = "jdbc:mysql://" + DBInfo.IP + ":" + DBInfo.PORT + "/"
                + db + "?useUnicode=true&characterEncoding=UTF8&useSSL=false";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        try {
            //DbUtils中加载驱动的方法
            DbUtils.loadDriver(jdbcDriver);
            conn = DriverManager.getConnection(jdbcURL,
                    DBInfo.USER, DBInfo.PASSWD);
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

    public void disconnect() {
        DbUtils.closeQuietly(conn);
    }

    /**
     * 执行更新的sql语句,插入,修改,删除
     *
     * @param sql
     * @return
     * @throws java.sql.SQLException
     */
    public boolean update(String sql, Object[] params) throws SQLException {
        boolean flag = false;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            int i = qRunner.update(conn, sql, params);
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return flag;
    }

    public boolean commit(String sqls[], Object[][] params) throws SQLException {
        boolean flag = false;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            QueryRunner qRunner = new QueryRunner();
            int i = 0;
            for (String sql : sqls) {
                qRunner.update(conn, sql, params[i++]);
            }
            DbUtils.commitAndCloseQuietly(conn);
            flag = true;
        } catch (SQLException e) {
            DbUtils.rollbackAndCloseQuietly(conn);
            throw e;
        }
        return flag;
    }

    /**
     * 查找多个对象
     *
     * @param sql
     * @param theClass
     * @return
     */
    public List query(String sql, Class theClass) throws SQLException {
        List beans = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            beans = (List) qRunner.query(conn,
                    sql,
                    new BeanListHandler(theClass));
            //BeanListHandler处理了从ResultSet中获取数据，封装对象并存入List集合
            //源码同样需要用到ResultSet
        } catch (SQLException e) {
            throw e;
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return beans;
    }

    /**
     * 重载查询多个对象方法
     *
     * @param sql
     * @param theClass
     * @return
     */
    public List query(String sql, Class theClass, Object[] params) throws SQLException {
        List beans = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            beans = (List) qRunner.query(conn, sql, new BeanListHandler(theClass), params);

            //BeanListHandler处理了从ResultSet中获取数据，封装对象并存入List集合
            //源码同样需要用到ResultSet
        } catch (SQLException e) {
            throw e;
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return beans;
    }

    /**
     * 查找对象
     *
     * @param sql
     * @param theClass
     * @return
     */
    public Object get(String sql, Class theClass) throws SQLException {
        Object obj = null;

        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            obj = qRunner.query(conn,
                    sql,
                    new BeanHandler(theClass));
        } catch (SQLException e) {
            throw e;
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return obj;
    }

    /**
     * 重载查询单对象方法
     *
     * @param sql
     * @param theClass
     * @return
     */
    public Object get(String sql, Class theClass, Object[] params) throws SQLException {
        Object obj = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            obj = qRunner.query(conn,
                    sql,
                    new BeanHandler(theClass), params);
        } catch (SQLException e) {
            throw e;
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return obj;
    }

}
