import { Candidate } from "./candidate";

export class CandidatePage{
    public content:Candidate[];
    public last:boolean;

    constructor(obj:CandidatePage)
    {
        this.content = obj.content;
        this.last = obj.last;
    }
}