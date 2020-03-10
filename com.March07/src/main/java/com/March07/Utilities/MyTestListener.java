package com.March07.Utilities;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.March07.Master.Master;

public class MyTestListener extends Master implements ITestListener, IRetryAnalyzer  {

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}
	
	  /**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   * @see ITestResult#STARTED
	   */
	
	  public void onTestStart(ITestResult result) {
		    // not implemented
		  
		  logger.info("MyList : " + result.getTestName());
		  
		  }

		  /**
		   * Invoked each time a test succeeds.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS
		   */
		  public void onTestSuccess(ITestResult result) {
		    // not implemented
			  
			  try {
				logger.info("MyList : " + result).addScreenCaptureFromPath(Utilities.getScreenShot());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }

		  /**
		   * Invoked each time a test fails.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#FAILURE
		   */
		  public void onTestFailure(ITestResult result) {
		    // not implemented
			  logger.info("MyList : " + result); 
		  }

		  /**
		   * Invoked each time a test is skipped.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SKIP
		   */
		  public void onTestSkipped(ITestResult result) {
		    // not implemented
			  logger.info("MyList : " + result);
		  }

		  /**
		   * Invoked each time a method fails but has been annotated with successPercentage and this failure
		   * still keeps it within the success percentage requested.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
		   */
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
			  logger.info("MyList : " + result);
		  }

		  /**
		   * Invoked each time a test fails due to a timeout.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   */
		  public void onTestFailedWithTimeout(ITestResult result) {
			  logger.info("MyList : " + result);  
		    onTestFailure(result);
		    
		  }

		  /**
		   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
		   * and calling all their Configuration methods.
		   */
		  public void onStart(ITestContext context) {
		    // not implemented
			  logger.info("MyList : " + context);
		  }

		  /**
		   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
		   * and all their Configuration methods have been called.
		   */
		  public void onFinish(ITestContext context) {
			  
			  logger.info("MyList : " + context.getName());
		    // not implemented
		  }
	

	
	
}
