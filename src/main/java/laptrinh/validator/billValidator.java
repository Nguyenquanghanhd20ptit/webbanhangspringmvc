package laptrinh.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import laptrinh.modell.user;
import laptrinh.service.user_interface;

@Service
public class billValidator implements Validator {
	@Autowired
	user_interface userDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
	    return	user.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		user user = (user) target;
		if(user.getEmail() == null || user.getEmail().length()==0) {
			errors.rejectValue("email", "requireEmail");
		}
		boolean check = false;
		for(int i=0;i<user.getEmail().length();i++) {
			if(user.getEmail().charAt(i)=='@') {
				check = true;
				break;
			}
		}
		if (check == false) {
			errors.rejectValue("email", "InvalidEmail");
		}
		if(user.getHoten() == null || user.getHoten().length()==0) {
			errors.rejectValue("hoten", "requireTen");
		}
		if(user.getDiachi() == null || user.getDiachi().length()==0) {
			errors.rejectValue("diachi", "requireDiachi");
		}
		if(user.getSdt() == null || user.getSdt().length()==0) {
			errors.rejectValue("sdt", "requireSdt");
		}
	}

}
