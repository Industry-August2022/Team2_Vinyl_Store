import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VinylDialogComponent } from './vinyl-dialog.component';

describe('VinylDialogComponent', () => {
  let component: VinylDialogComponent;
  let fixture: ComponentFixture<VinylDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VinylDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VinylDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
