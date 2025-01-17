import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-result-modal',
  templateUrl: './result-modal.component.html',
  styleUrls: ['./result-modal.component.css'],
})
export class ResultModalComponent {
  @Input() plate = '';
  @Input() date = '';
  @Input() hour = '';
  @Input() result = '';
  @Output() closeModal = new EventEmitter<void>(); // Evento para cerrar el modal

  // Método para cerrar el modal
  onClose(): void {
    this.closeModal.emit();
  }
}
