package bussinesslogic.examinebl;

import java.util.ArrayList;
import org.junit.*;
import dataenum.findtype.FindBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;
import dataenum.BillType;
import bussinesslogic.billbl.inventory.InventoryTransition;
import vo.commodityvo.GiftVO;
import dataenum.BillState;
import dataenum.ResultMessage;
import static org.junit.Assert.*;

/**
 * The class <code>ExamineInventoryBLTest</code> contains tests for the class <code>{@link ExamineInventoryBL}</code>.
 *
 * @generatedBy CodePro at 18-1-12 ����9:21
 * @author asus
 * @version $Revision: 1.0 $
 */
public class ExamineInventoryBLTest {
	/**
	 * Run the ExamineInventoryBL() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testExamineInventoryBL_1()
		throws Exception {

		ExamineInventoryBL result = new ExamineInventoryBL();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.InstanceCreationExpression.execute(InstanceCreationExpression.java:425)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillVO> find(String,FindBillType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testFind_1()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		String info = "";
		FindBillType type = FindBillType.ACCOUNT;

		ArrayList<InventoryBillVO> result = fixture.find(info, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillVO> find(String,FindBillType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testFind_2()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		String info = "";
		FindBillType type = FindBillType.ACCOUNT;

		ArrayList<InventoryBillVO> result = fixture.find(info, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillVO> find(String,FindBillType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testFind_3()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		String info = "";
		FindBillType type = FindBillType.ACCOUNT;

		ArrayList<InventoryBillVO> result = fixture.find(info, type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillVO> getCommitedBills() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testGetCommitedBills_1()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();

		ArrayList<InventoryBillVO> result = fixture.getCommitedBills();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillVO> getCommitedBills() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testGetCommitedBills_2()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();

		ArrayList<InventoryBillVO> result = fixture.getCommitedBills();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<InventoryBillVO> getCommitedBills() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testGetCommitedBills_3()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();

		ArrayList<InventoryBillVO> result = fixture.getCommitedBills();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage notPassBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testNotPassBills_1()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.notPassBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage notPassBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testNotPassBills_2()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.notPassBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage notPassBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testNotPassBills_3()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.notPassBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage notPassBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testNotPassBills_4()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.notPassBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage notPassBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testNotPassBills_5()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.notPassBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage notPassBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testNotPassBills_6()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.notPassBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage notPassBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testNotPassBills_7()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.notPassBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_1()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_2()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_3()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_4()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_5()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_6()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_7()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_8()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_9()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_10()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_11()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage passBills(ArrayList<InventoryBillVO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testPassBills_12()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		ArrayList<InventoryBillVO> vos = new ArrayList();

		ResultMessage result = fixture.passBills(vos);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateBill(InventoryBillVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testUpdateBill_1()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		InventoryBillVO vo = new InventoryBillVO("", new ArrayList(), "", BillType.INVENTORYBILL, BillState.COMMITED, "");

		ResultMessage result = fixture.updateBill(vo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the ResultMessage updateBill(InventoryBillVO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Test
	public void testUpdateBill_2()
		throws Exception {
		ExamineInventoryBL fixture = new ExamineInventoryBL();
		fixture.transition = new InventoryTransition();
		InventoryBillVO vo = new InventoryBillVO("", new ArrayList(), "", BillType.INVENTORYBILL, BillState.COMMITED, "");

		ResultMessage result = fixture.updateBill(vo);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: bussinesslogic.examinebl.ExamineInventoryBL
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 18-1-12 ����9:21
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ExamineInventoryBLTest.class);
	}
}