/*export interface Candidate {
  firstAndLastName: string;
  JMBG: string;
  yearOfBirth: Date;
  mail: string;
  telephoneNumber: string;
  isEmployed: boolean;
  lastChange: Date;
}*/

interface CandidateInterface{
  firstAndLastName: string;
  JMBG: string;
  yearOfBirth: Date;
  mail: string;
  telephoneNumber: string;
  isEmployed: boolean;
  lastChange: Date;
}
export class Candidate implements CandidateInterface{
  firstAndLastName: string;
  JMBG: string;
  yearOfBirth: Date;
  mail: string;
  telephoneNumber: string;
  isEmployed: boolean;
  lastChange: Date;
  
  constructor(obj:CandidateInterface){
      this.firstAndLastName=obj.firstAndLastName;
      this.JMBG=obj.JMBG;
      this.yearOfBirth=obj.yearOfBirth;
      this.mail=obj.mail;
      this.telephoneNumber=obj.telephoneNumber;
      this.isEmployed=obj.isEmployed;
      this.lastChange=obj.lastChange;
  }
}
