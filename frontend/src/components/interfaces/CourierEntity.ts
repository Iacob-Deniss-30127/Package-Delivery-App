interface CourierEntity {
  id: number; // or string if that's how your ID is defined
  name: string;
  email: string;
  isManager: boolean;
  manager?: {
    id: number; // or string
  } | null; // Optional, in case a courier has no manager
}
