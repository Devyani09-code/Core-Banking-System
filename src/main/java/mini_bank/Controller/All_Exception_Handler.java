package mini_bank.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class All_Exception_Handler {

	@ExceptionHandler(Exception.class)//Exception.class handles all exceptions,for specific ones write specific name
	@ResponseBody
	public String handling_method(Exception e) {
		return "Something went wrong,please wait for some time\n"+e.getMessage();
	}
}
