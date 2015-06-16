package lee;

import org.crazyit.app.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewsManager {

	public static void main(String[] args) throws Exception {
		// 实例化Configuration，
		Configuration conf = new Configuration()
		// 下面方法默认加载hibernate.cfg.xml文件
				.configure();
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 创建消息实例

		// 设置消息标题和消息内容
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String TimeString = time.format(new java.util.Date());
		System.out.println(TimeString);
		for (int i = 100000; i < 200000; i++) {
			News n = new News();
			n.setId(i);
			n.setTitle("lj");

			// 保存消息
			sess.save(n);
			if (i % 80 == 0) {
				sess.flush();
				sess.clear();
			}
		}
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		SimpleDateFormat times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String TimeStrings = times.format(new java.util.Date());
		System.out.println(TimeStrings);
		System.out.println("lj");
	}
}
