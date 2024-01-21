import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PieCreatorComponent } from './pie-creator.component';

describe('PieCreatorComponent', () => {
  let component: PieCreatorComponent;
  let fixture: ComponentFixture<PieCreatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PieCreatorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PieCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
