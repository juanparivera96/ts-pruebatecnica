import { Employee } from './employee.model';

export class Activity{
    id!: number;
    estimationDate!: Date;
    delay!: number;
    status!: string;
    employee!: Employee;
    description!: string;
}