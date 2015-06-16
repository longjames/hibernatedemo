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
		// ʵ����Configuration��
		Configuration conf = new Configuration()
		// ���淽��Ĭ�ϼ���hibernate.cfg.xml�ļ�
				.configure();
		// ��Configuration����SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// ����Session
		Session sess = sf.openSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ������Ϣʵ��

		// ������Ϣ�������Ϣ����
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String TimeString = time.format(new java.util.Date());
		System.out.println(TimeString);
		for (int i = 100000; i < 200000; i++) {
			News n = new News();
			n.setId(i);
			n.setTitle("lj");

			// ������Ϣ
			sess.save(n);
			if (i % 80 == 0) {
				sess.flush();
				sess.clear();
			}
		}
		// �ύ����
		tx.commit();
		// �ر�Session
		sess.close();
		sf.close();
		SimpleDateFormat times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String TimeStrings = times.format(new java.util.Date());
		System.out.println(TimeStrings);
		System.out.println("lj");
	}
}
