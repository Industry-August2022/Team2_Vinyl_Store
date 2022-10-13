import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { vinylDialogData } from 'src/app/api-classes/vinylDialogData';

@Component({
  selector: 'app-vinyl-dialog',
  templateUrl: './vinyl-dialog.component.html',
  styleUrls: ['./vinyl-dialog.component.css']
})
export class VinylDialogComponent implements OnInit {

  constructor(public dialogRef:MatDialogRef<VinylDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: vinylDialogData) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
