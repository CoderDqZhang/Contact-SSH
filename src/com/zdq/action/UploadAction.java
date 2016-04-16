package com.zdq.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zdq.dao.CompanyDao;
import com.zdq.dao.impl.CompanyDaoImp;
import com.zdq.java.tool.CompanyService;
import com.zdq.model.Company;

public class UploadAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CompanyDao companyDao = new CompanyDaoImp();
	CompanyService companyService;
	private Map<String,Object> session;
  //上传文件存放路径   
    private final static String UPLOADDIR = "/upload";   
    //上传文件集合   
    private List<File> file;   
    //上传文件名集合   
    private List<String> fileFileName;   
    //上传文件内容类型集合   
    private List<String> fileContentType;   
    public List<File> getFile() {   
        return file;   
    }   

    public void setFile(List<File> file) {   
        this.file = file;   
    }   

   public List<String> getFileFileName() {   
       return fileFileName;   
   }   

    public void setFileFileName(List<String> fileFileName) {   
        this.fileFileName = fileFileName;   
    }   

    public List<String> getFileContentType() {   
        return fileContentType;   
    }   

    public void setFileContentType(List<String> fileContentType) {   
        this.fileContentType = fileContentType;   
    } 
	
    public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	
	public String execute() throws Exception {   
        System.out.println(this.getFileFileName());  
        for (int i = 0; i < file.size(); i++) {   
            //循环上传每个文件   
            uploadFile(i);   
        }   
        return "success";   
    }   

    //执行上传功能   
    private void uploadFile(int i) throws FileNotFoundException, IOException {   
        try {   
            InputStream in = new FileInputStream(file.get(i));
            companyService = new CompanyService();
            String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);  
            File fileLocation = new File(dir);
            //此处也可以在应用根目录手动建立目标上传目录  
            if(!fileLocation.exists()){  
                boolean isCreated  = fileLocation.mkdir();  
                if(!isCreated) {  
                    //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。  
                    return;  
                }  
            }  
            String fileName=this.getFileFileName().get(i);  
            File uploadFile = new File(dir, fileName);   
            OutputStream out = new FileOutputStream(uploadFile);   
            byte[] buffer = new byte[1024 * 1024];   
            int length;   
            while ((length = in.read(buffer)) > 0) {   
                out.write(buffer, 0, length);   
            }
            try {
				List<Company> company = companyService.getAllByExcel(dir+"/"+fileName);
				companyDao.saveCompany(company);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            in.close();   
            out.close();   
        } catch (FileNotFoundException ex) {   
            System.out.println("上传失败!");  
            ex.printStackTrace();   
        } catch (IOException ex) {   
            System.out.println("上传失败!");  
            ex.printStackTrace();   
        }   
    }   
}
