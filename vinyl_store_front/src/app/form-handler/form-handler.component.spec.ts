import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormHandlerComponent } from './form-handler.component';

describe('FormHandlerComponent', () => {
  let component: FormHandlerComponent;
  let fixture: ComponentFixture<FormHandlerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormHandlerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormHandlerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
