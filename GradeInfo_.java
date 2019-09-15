
public interface GradeInfo_ {

	enum LetterGrade {
		A, Aminus, B, Bminus, C, Cminus, D, E, F, I 
	   } 
	   public static int gradepoint(GradeInfo_.LetterGrade grade) {
		   int ans=0;
		   switch(grade)
		   {
		   case A:
			   ans=10;
			   break;
		   case Aminus:
			   ans=9;
			   break;
		   case B:
			   ans=8;
			   break;
		   case Bminus:
			   ans=7;
			   break;
		   case C:
			   ans=6;
			   break;
		   case Cminus:
			   ans=5;
			   break;
		   case D:
			   ans=4;
			   break;
		   case E:
			   ans=3;
			   break;
		   case F:
			   ans=2;
			   break;
		   case I:
			   ans=0;
			   break;
		   }
		   return ans;
	   }
}
class gradeinfo implements GradeInfo_{
	GradeInfo_.LetterGrade sgrade;
	public gradeinfo(String grades) {
		switch(grades) {
		case "A":
			sgrade=GradeInfo_.LetterGrade.A;
			break;
		case "Aminus":
			sgrade=GradeInfo_.LetterGrade.Aminus;
			break;
		case "B":
			sgrade=GradeInfo_.LetterGrade.B;
			break;
		case "Bminus":
			sgrade=GradeInfo_.LetterGrade.Bminus;
			break;
		case "C":
			sgrade=GradeInfo_.LetterGrade.C;
			break;
		case "Cminus":
			sgrade=GradeInfo_.LetterGrade.Cminus;
			break;
		case "D":
			sgrade=GradeInfo_.LetterGrade.D;
			break;
		case "E":
			sgrade=GradeInfo_.LetterGrade.E;
			break;
		case "F":
			sgrade=GradeInfo_.LetterGrade.F;
			break;
		case "I":
			sgrade=GradeInfo_.LetterGrade.I;
			break;
		}
	}
}