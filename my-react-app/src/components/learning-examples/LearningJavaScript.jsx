const person = {
    name: 'Rohit',
    address: {
        line1:`123, ABC Street`,
        city: 'Pune',
        country: 'India',
    },
    profiles: ['facebook', 'twitter', 'instagram'],
    printprofiles:  () => {
        person.profiles.map(
            profile => console.log(profile)
        )
    }
    // function() {
    //     return `${this.profiles[0]}, ${this.profiles[1]}, ${this.profiles[2]}`;
    // }
}

// function printProfiles()    {
//     // console.log(this);
// }


export default function LearniningJavaScript() {
    return (
        <>
        <div>--- Learninig JavaScript Component ---</div>
        <div>{person.name}</div>
        <div>{person.address.line1}</div>
        <div>{person.address.city}</div>
        <div>{person.address.country}</div>
        <div>{person.printprofiles()}</div>
        </>
    )
}