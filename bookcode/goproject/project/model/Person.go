package model

type Person struct {
	Name string `json:"name"`
	Age int `json:"age"`
} 

//GetName is get person name
func (p *Person) GetName() string {
	return p.Name
}

func (p *Person) GetAge() int{
	return p.Age
}