//import java.util.Iterator;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
public class Assignment1 {
	static linkedlist<student> stlist=new linkedlist<student>();
	static linkedlist<hostel> allhostels=new linkedlist<hostel>();
	static linkedlist<department> alldepartments=new linkedlist<department>();
	static linkedlist<course> allcourses=new linkedlist<course>();
	public static void main(String[] args) throws IOException {	
		
		String[] Data=getData(args[0],args[1],args[2]);
		
		String[] arrofcourse=Data[0].split("\n");
		String[] arrofcoursedetails=Data[1].split("\n");
		String[] arrofquery=Data[2].split("\n");	
		
		for(int i=0;i<arrofcourse.length;i++) {
			String[] farrstudent=arrofcourse[i].split(" ");
			student temp=new student(farrstudent[1],farrstudent[0],farrstudent[3],farrstudent[2]);
			Position_<student> idknow=stlist.add(temp);
			int initialhostelcount=allhostels.count();
			boolean checkhostelpresence=false;
			Iterator<Position_<hostel>> hitr=allhostels.positions();
				for(int h=0;h<initialhostelcount;h++) {
					Position_<hostel> hikr=hitr.next();
					hostel hyouknow=hikr.value();
					String hostring=farrstudent[3];
						if(hostring.equals(hyouknow.name())) {
							checkhostelpresence=true;
							hyouknow.addstudent(temp);
							break;
						}
				}
				if(checkhostelpresence==false) {
					hostel newhostel=new hostel(farrstudent[3]);
					newhostel.addstudent(temp);
					Position_<hostel> hidknow=allhostels.add(newhostel);
				}
			int initialdepartmentcount=alldepartments.count();
			boolean checkdepartmentpresence=false;
			Iterator<Position_<department>> ditr=alldepartments.positions();
				for(int h=0;h<initialdepartmentcount;h++) {
					Position_<department> dikr=ditr.next();
					department dyouknow=dikr.value();
					String departmentstring=farrstudent[2];
					if(departmentstring.equals(dyouknow.name())) {
						checkdepartmentpresence=true;
						dyouknow.addstudent(temp);
						break;
					}
				}
				if(checkdepartmentpresence==false) {
					department newdepartment=new department(farrstudent[2]);
					newdepartment.addstudent(temp);
					Position_<department> hidknow=alldepartments.add(newdepartment);
				}
			
		}
		/*String[] fhcourse=arrofcoursedetails[arrofcoursedetails.length-1].split(" ",4);
		String[] fgcourse=arrofcoursedetails[6].split(" ",4);
		System.out.println(fhcourse[3]);
		System.out.println(fgcourse[3]);
		System.out.println(fhcourse[3].length());
		System.out.println(fgcourse[3].length());
		System.out.println(fhcourse[3].equals(fgcourse[3]));*/
		for(int j=0;j<arrofcoursedetails.length;j++) {
			String[] fcourse=arrofcoursedetails[j].split(" ",4);
			gradeinfo resgrades=new gradeinfo(fcourse[2]);
			courseinfo thiscourse=new courseinfo(fcourse[3],fcourse[1],resgrades);			
			Iterator<Position_<student>> itr=stlist.positions();
			student check=null;
				for(int i=0;i<stlist.count();i++) {	
					Position_<student> ikr=itr.next();
					String entry=fcourse[0];
					if(entry.equals(ikr.value().entryNo())) {
						student youknow=ikr.value();
						check=youknow;
						youknow.addcourse(thiscourse);
					}				
				}
			int initialcoursecount=allcourses.count();
			boolean checkcoursepresence=false;
			Iterator<Position_<course>> coitr=allcourses.positions();
				for(int h=0;h<allcourses.count();h++) {
					Position_<course> coikr=coitr.next();
					course coyouknow=coikr.value();
					String coursestring=fcourse[3];
					if(coursestring.equals(coyouknow.name())||fcourse[1].equals(coyouknow.code())) {					
						checkcoursepresence=true;
						coyouknow.addstudent(check);
						break;
					}
				}
				if(checkcoursepresence==false) {
					course newcourse=new course(fcourse[3],fcourse[1]);
					newcourse.addstudent(check);
					Position_<course> coidknow=allcourses.add(newcourse);
				}			
			}
		Iterator<Position_<hostel>> itr=allhostels.positions();
		for(int i=0;i<allhostels.count();i++) {
			Position_<hostel> ikr=itr.next();
			hostel youknow=ikr.value();
			Iterator<Student_> itr1=youknow.studentList();
			//System.out.println(youknow.name());
			for(int j=0;j<youknow.countstudents;j++) {
				Student_ hello=itr1.next();
				//System.out.println(hello.name());
				//System.out.println(hello.cgpa());
			}
		}
		Iterator<Position_<course>> itr1=allcourses.positions();
		for(int i=0;i<allcourses.count();i++) {
			Position_<course> ikr=itr1.next();
			course youknow=ikr.value();
			Iterator<Student_> itr2=youknow.studentList();
			//System.out.println(youknow.name());
			for(int j=0;j<youknow.countstudents;j++) {
				//System.out.println(itr2.next().name());
				
			}
		}
	
		/*System.out.println(allcourses.count());
		System.out.println(allhostels.count());
		System.out.println(alldepartments.count());
		System.out.println(Data[2]);*/
		for(int y=(arrofquery.length-1);y>=0;y--) {
			answerQueries(arrofquery[y]);
		}
	}
	private static String[] getData(String file1,String file2,String file3) throws IOException {
		FileInputStream fle1= new FileInputStream(System.getProperty("user.dir")+"\\"+file1);
		FileInputStream fle2= new FileInputStream(System.getProperty("user.dir")+"\\"+file2);
		FileInputStream fle3= new FileInputStream(System.getProperty("user.dir")+"\\"+file3);
		int ch;
		String[] total=new String[3];
		String tem="";
		String help="";
		String wth="";
        while((ch=fle1.read())!=-1) { 
        	char c=(char)ch;
        	tem=tem+Character.toString(c);
            //System.out.print((char)ch);
        }
        total[0]=tem;
        //System.out.println(" ");
        while((ch=fle2.read())!=-1) { 
        	char c=(char)ch;
        	help=help+Character.toString(c);
            //System.out.print((char)ch);
        }
        
        total[1]=help;
        while((ch=fle3.read())!=-1) { 
        	char c=(char)ch;
        	wth=wth+Character.toString(c);
            //System.out.print((char)ch);
        }
        total[2]=wth;
		fle1.close();
		fle2.close();
		fle3.close();
		return total;
	}

	private static void answerQueries(String query) {
		String[] initialsplit=query.split(" ", 2);
		switch(initialsplit[0]) {
		case "INFO":
			Iterator<Position_<student>> stuquery=stlist.positions();
			for(int i=0;i<stlist.count();i++) {
				Position_<student> checkstudent=stuquery.next();
				student maybethisstudent=checkstudent.value();
				if(initialsplit[1].equals(maybethisstudent.entryNo())) {
					String printstring=maybethisstudent.entryNo()+" "+maybethisstudent.name()+" "+maybethisstudent.department()+" "+maybethisstudent.hostel()+" "+maybethisstudent.cgpa()+" ";
					Iterator<CourseGrade_> hiscourses=maybethisstudent.courseList();
					String coursestoadd="";
					for(int j=0;j<maybethisstudent.countcourses;j++) {
						CourseGrade_ currentcourse=hiscourses.next();
						gradeinfo currentgrade=(gradeinfo)currentcourse.grade();
						coursestoadd=coursestoadd+currentcourse.coursenum()+" "+currentgrade.sgrade+" ";
					}
					String finalprintstring=printstring+coursestoadd;
					System.out.println(finalprintstring);
				}
			}
			break;
		case "SHARE":
			Iterator<Position_<student>> stushquery=stlist.positions();
			String[] answerarray=null;
			String[] finalsplit=initialsplit[1].split(" ",2);
			for(int i=0;i<stlist.count();i++) {
				Position_<student> checkstudent=stushquery.next();
				student maybethisstudent=checkstudent.value();
				if(finalsplit[0].equals(maybethisstudent.entryNo())) {
					if(finalsplit[1].equals(maybethisstudent.hostel())) {
						Iterator<Position_<hostel>> awhostels=allhostels.positions();
						for(int v=0;v<allhostels.count();v++) {
							Position_<hostel> whathostel=awhostels.next();
							hostel seriously=whathostel.value();
							if(finalsplit[1].equals(seriously.name())) {
								answerarray=new String[seriously.countstudents];
								Iterator<Student_> frick=seriously.studentList();
								for(int k=0;k<seriously.countstudents;k++) {
									Student_ hey=frick.next();
									if(hey.entryNo().equals(finalsplit[0])) {
										answerarray[k]="0";
									}
									else {
										answerarray[k]=hey.entryNo();
									}
								}
								break;
							}
						}
						break;
					}
					else if(finalsplit[1].equals(maybethisstudent.department())) {
						Iterator<Position_<department>> awdepartments=alldepartments.positions();
						for(int v=0;v<alldepartments.count();v++) {
							Position_<department> whatdepartment=awdepartments.next();
							department seriously=whatdepartment.value();
							if(finalsplit[1].equals(seriously.name())) {
								answerarray=new String[seriously.countstudents];
								Iterator<Student_> frick=seriously.studentList();
								for(int k=0;k<seriously.countstudents;k++) {
									Student_ hey=frick.next();
									if(hey.entryNo().equals(finalsplit[0])) {
										answerarray[k]="0";
									}
									else {
										answerarray[k]=hey.entryNo();
									}
								}
								break;
							}
						}
						break;
					}
					else {
						Iterator<Position_<course>> awcourses=allcourses.positions();
						for(int v=0;v<allcourses.count();v++) {
							Position_<course> whatcourse=awcourses.next();
							course seriously=whatcourse.value();
							if(finalsplit[1].equals(seriously.code())) {
								answerarray=new String[seriously.countstudents];
								Iterator<Student_> frick=seriously.studentList();
								for(int k=0;k<seriously.countstudents;k++) {
									Student_ hey=frick.next();
									if(hey.entryNo().equals(finalsplit[0])) {
										answerarray[k]="0";
									}
									else {
										answerarray[k]=hey.entryNo();
									}
								}
								break;
							}
						}
						break;
					}
				}
			}
			Arrays.sort(answerarray);
			String printanswer="";
			for(int w=0;w<answerarray.length;w++) {
				if(answerarray[w]=="0") {
					;
				}
				else {
					printanswer=printanswer+answerarray[w]+" ";
				}
			}
			System.out.println(printanswer);
			break;
		case "COURSETITLE":
			Iterator<Position_<course>> coquery=allcourses.positions();
			for(int i=0;i<allcourses.count();i++) {
				Position_<course> checkcourse=coquery.next();
				course maybethiscourse=checkcourse.value();
				if(initialsplit[1].equals(maybethiscourse.code())) {
					System.out.println(maybethiscourse.name());
					break;
				}
			}
			break;
		}
	}
}